package org.softuni.summermvc.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PathFormatter {
    private static final String PATH_PARAMETER_PATTERN = "\\{([a-zA-Z]+)\\}";

    private static final String PATH_PARSED_PARAMETER_PATTERN = "(?<group-name>[a-zA-Z0-9_-]+)";

    public static String formatPath(String path) {
        Pattern pathParameterPattern = Pattern.compile(PATH_PARAMETER_PATTERN);
        Matcher pathParameterMatcher = pathParameterPattern.matcher(path);

        String formatterPath = path;

        while(pathParameterMatcher.find()) {
            String parameterName = pathParameterMatcher.group(1);

            String formattedParameterPattern = PATH_PARSED_PARAMETER_PATTERN.replace("group-name", parameterName);

            formatterPath = formatterPath.replaceFirst(PATH_PARAMETER_PATTERN, formattedParameterPattern);
        }

        return formatterPath;
    }
}
