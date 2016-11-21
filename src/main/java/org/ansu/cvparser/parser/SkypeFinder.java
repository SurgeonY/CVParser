package org.ansu.cvparser.parser;

import org.ansu.cvparser.parser.entries.SimpleEntry;
import org.ansu.cvparser.parser.entries.Entry;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.ansu.cvparser.RegExp.maybeMany;
import static org.ansu.cvparser.RegExp.Lexemes.HSpace;

/**
 * Author: Andrii Sushkovych
 * Date: 11/21/16
 */
public class SkypeFinder implements Finder {
    public static final String REG_EXP = "(?im)\\s*skype" + maybeMany(HSpace)+ ":" + maybeMany(HSpace) + "(\\S+)\\s";
    private static final Pattern PATTERN = Pattern.compile(REG_EXP);

    @Override
    public String getName() {
        return "Skype";
    }

    // Do not replace with SimpleFinder's find() as the group number differs
    @Override
    public Entry find(String text) {
        Matcher matcher = PATTERN.matcher(text);
        if (matcher.find()) {
            return new SimpleEntry(matcher.group(1));
        }
        return null;
    }
}
