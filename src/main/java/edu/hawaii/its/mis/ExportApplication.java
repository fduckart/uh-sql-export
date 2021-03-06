package edu.hawaii.its.mis;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.hawaii.its.mis.service.ExportService;

@SpringBootApplication
public class ExportApplication implements CommandLineRunner {

    @Autowired
    private ExportService exportService;

    public static void main(String[] args) {
        checkUsage(args);
        SpringApplication.run(ExportApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        exportService.export();
    }

    public static void checkUsage(String[] args) {
        boolean hasRequiredArg = false;
        StringBuilder usage = new StringBuilder();
        if (args.length > 0) {
            String regex = "(--spring.config.location=)(\\S+)";
            Pattern pattern = Pattern.compile(regex);
            for (String arg : args) {
                Matcher matcher = pattern.matcher(arg);
                if (matcher.find()) {
                    String filename = matcher.group(2);
                    Path path = Paths.get(filename);
                    hasRequiredArg = Files.exists(path);
                    if (!hasRequiredArg) {
                        usage.append("Error: '");
                        usage.append(filename);
                        usage.append("' configuration file does not exist.\n");
                    }
                    break;
                }
            }
        }

        if (!hasRequiredArg) {
            usage.append("usage: java -jar exporter.jar ");
            usage.append("--spring.config.location=exporter.properties");
            System.err.println(usage);
            System.exit(1);
        }
    }
}
