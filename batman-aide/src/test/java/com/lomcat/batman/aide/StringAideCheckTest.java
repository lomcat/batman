/*
 * Copyright 2018-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lomcat.batman.aide;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.StringReader;

/**
 * @author Kweny
 * @since 0.0.1
 */
public class StringAideCheckTest {

    @Test
    public void testIsEmpty() {
        Assertions.assertTrue(StringAide.isEmpty(null));
        Assertions.assertTrue(StringAide.isEmpty(""));
        Assertions.assertFalse(StringAide.isEmpty(" "));
        Assertions.assertFalse(StringAide.isEmpty("bob"));
        Assertions.assertFalse(StringAide.isEmpty("  bob  "));
    }

    @Test
    public void testIsNotEmpty() {
        Assertions.assertFalse(StringAide.isNotEmpty(null));
        Assertions.assertFalse(StringAide.isNotEmpty(""));
        Assertions.assertTrue(StringAide.isNotEmpty(" "));
        Assertions.assertTrue(StringAide.isNotEmpty("bob"));
        Assertions.assertTrue(StringAide.isNotEmpty("  bob  "));
    }

    @Test
    public void testIsAllEmpty() {
        Assertions.assertTrue(StringAide.isAllEmpty((String) null));
        Assertions.assertTrue(StringAide.isAllEmpty((String[]) null));
        Assertions.assertTrue(StringAide.isAllEmpty(null, ""));
        Assertions.assertTrue(StringAide.isAllEmpty("", ""));
        Assertions.assertTrue(StringAide.isAllEmpty(new String[] {}));
        Assertions.assertFalse(StringAide.isAllEmpty(null, "foo"));
        Assertions.assertFalse(StringAide.isAllEmpty("", "bar"));
        Assertions.assertFalse(StringAide.isAllEmpty("bob", ""));
        Assertions.assertFalse(StringAide.isAllEmpty("  bob  ", null));
        Assertions.assertFalse(StringAide.isAllEmpty(" ", "bar"));
        Assertions.assertFalse(StringAide.isAllEmpty("foo", "bar"));
    }

    @Test
    public void testIsAnyEmpty() {
        Assertions.assertTrue(StringAide.isAnyEmpty((String) null));
        Assertions.assertFalse(StringAide.isAnyEmpty((String[]) null));
        Assertions.assertTrue(StringAide.isAnyEmpty(null, "foo"));
        Assertions.assertTrue(StringAide.isAnyEmpty("", "bar"));
        Assertions.assertTrue(StringAide.isAnyEmpty("bob", ""));
        Assertions.assertTrue(StringAide.isAnyEmpty("  bob  ", null));
        Assertions.assertFalse(StringAide.isAnyEmpty(" ", "bar"));
        Assertions.assertFalse(StringAide.isAnyEmpty("foo", "bar"));
        Assertions.assertFalse(StringAide.isAnyEmpty(new String[]{}));
        Assertions.assertTrue(StringAide.isAnyEmpty(new String[]{""}));
    }

    @Test
    public void testIsNoneEmpty() {
        Assertions.assertFalse(StringAide.isNoneEmpty((String) null));
        Assertions.assertTrue(StringAide.isNoneEmpty((String[]) null));
        Assertions.assertFalse(StringAide.isNoneEmpty(null, "foo"));
        Assertions.assertFalse(StringAide.isNoneEmpty("", "bar"));
        Assertions.assertFalse(StringAide.isNoneEmpty("bob", ""));
        Assertions.assertFalse(StringAide.isNoneEmpty("  bob  ", null));
        Assertions.assertTrue(StringAide.isNoneEmpty(new String[] {}));
        Assertions.assertFalse(StringAide.isNoneEmpty(new String[]{""}));
        Assertions.assertTrue(StringAide.isNoneEmpty(" ", "bar"));
        Assertions.assertTrue(StringAide.isNoneEmpty("foo", "bar"));
    }

    @Test
    public void testIsBlank() {
        Assertions.assertTrue(StringAide.isBlank(null));
        Assertions.assertTrue(StringAide.isBlank(""));
        Assertions.assertTrue(StringAide.isBlank(" "));
        Assertions.assertFalse(StringAide.isBlank("bob"));
        Assertions.assertFalse(StringAide.isBlank("  bob  "));
    }

    @Test
    public void testIsNotBlank() {
        Assertions.assertFalse(StringAide.isNotBlank(null));
        Assertions.assertFalse(StringAide.isNotBlank(""));
        Assertions.assertFalse(StringAide.isNotBlank(" "));
        Assertions.assertTrue(StringAide.isNotBlank("bob"));
        Assertions.assertTrue(StringAide.isNotBlank("  bob  "));
    }

    @Test
    public void testIsAllBlank() {
        Assertions.assertTrue(StringAide.isAllBlank((String) null));
        Assertions.assertTrue(StringAide.isAllBlank((String[]) null));
        Assertions.assertFalse(StringAide.isAllBlank(null, "foo"));
        Assertions.assertTrue(StringAide.isAllBlank(null, null));
        Assertions.assertFalse(StringAide.isAllBlank("", "bar"));
        Assertions.assertFalse(StringAide.isAllBlank("bob", ""));
        Assertions.assertFalse(StringAide.isAllBlank("  bob  ", null));
        Assertions.assertFalse(StringAide.isAllBlank("  bob  ", null));
        Assertions.assertFalse(StringAide.isAllBlank(" ", "bar"));
        Assertions.assertFalse(StringAide.isAllBlank(" ", "bar"));
        Assertions.assertFalse(StringAide.isAllBlank("foo", "bar"));
        Assertions.assertTrue(StringAide.isAllBlank(new String[] {}));
        Assertions.assertTrue(StringAide.isAllBlank("", "", " "));
    }

    @Test
    public void testIsAnyBlank() {
        Assertions.assertTrue(StringAide.isAnyBlank((String) null));
        Assertions.assertFalse(StringAide.isAnyBlank((String[]) null));
        Assertions.assertTrue(StringAide.isAnyBlank(null, "foo"));
        Assertions.assertTrue(StringAide.isAnyBlank(null, null));
        Assertions.assertTrue(StringAide.isAnyBlank("", "bar"));
        Assertions.assertTrue(StringAide.isAnyBlank("bob", ""));
        Assertions.assertTrue(StringAide.isAnyBlank("  bob  ", null));
        Assertions.assertTrue(StringAide.isAnyBlank(" ", "bar"));
        Assertions.assertFalse(StringAide.isAnyBlank(new String[] {}));
        Assertions.assertTrue(StringAide.isAnyBlank(new String[]{""}));
        Assertions.assertFalse(StringAide.isAnyBlank("foo", "bar"));
    }

    @Test
    public void testIsNoneBlank() {
        Assertions.assertFalse(StringAide.isNoneBlank((String) null));
        Assertions.assertTrue(StringAide.isNoneBlank((String[]) null));
        Assertions.assertFalse(StringAide.isNoneBlank(null, "foo"));
        Assertions.assertFalse(StringAide.isNoneBlank(null, null));
        Assertions.assertFalse(StringAide.isNoneBlank("", "bar"));
        Assertions.assertFalse(StringAide.isNoneBlank("bob", ""));
        Assertions.assertFalse(StringAide.isNoneBlank("  bob  ", null));
        Assertions.assertFalse(StringAide.isNoneBlank(" ", "bar"));
        Assertions.assertTrue(StringAide.isNoneBlank(new String[] {}));
        Assertions.assertFalse(StringAide.isNoneBlank(new String[]{""}));
        Assertions.assertTrue(StringAide.isNoneBlank("foo", "bar"));
    }

    @Test
    public void testIsAllLowerCase() {
        Assertions.assertFalse(StringAide.isAllLowerCase(null));
        Assertions.assertFalse(StringAide.isAllLowerCase(""));
        Assertions.assertFalse(StringAide.isAllLowerCase("  "));
        Assertions.assertTrue(StringAide.isAllLowerCase("abc"));
        Assertions.assertFalse(StringAide.isAllLowerCase("abC"));
        Assertions.assertFalse(StringAide.isAllLowerCase("ab c"));
        Assertions.assertFalse(StringAide.isAllLowerCase("ab1c"));
        Assertions.assertFalse(StringAide.isAllLowerCase("ab/c"));
    }

    @Test
    public void testIsAnyLowerCase() {
        Assertions.assertFalse(StringAide.isAnyLowerCase(null));
        Assertions.assertFalse(StringAide.isAnyLowerCase(""));
        Assertions.assertFalse(StringAide.isAnyLowerCase("  "));
        Assertions.assertFalse(StringAide.isAnyLowerCase("ABC"));
        Assertions.assertFalse(StringAide.isAnyLowerCase("123"));
        Assertions.assertTrue(StringAide.isAnyLowerCase("abc"));
        Assertions.assertTrue(StringAide.isAnyLowerCase("abC"));
        Assertions.assertTrue(StringAide.isAnyLowerCase("ab c"));
        Assertions.assertTrue(StringAide.isAnyLowerCase("ab1c"));
        Assertions.assertTrue(StringAide.isAnyLowerCase("ab/c"));
    }

    @Test
    public void testIsNoneLowerCase() {
        Assertions.assertTrue(StringAide.isNoneLowerCase(null));
        Assertions.assertTrue(StringAide.isNoneLowerCase(""));
        Assertions.assertTrue(StringAide.isNoneLowerCase("  "));
        Assertions.assertTrue(StringAide.isNoneLowerCase("ABC"));
        Assertions.assertTrue(StringAide.isNoneLowerCase("123"));
        Assertions.assertFalse(StringAide.isNoneLowerCase("abc"));
        Assertions.assertFalse(StringAide.isNoneLowerCase("abC"));
        Assertions.assertFalse(StringAide.isNoneLowerCase("ab c"));
        Assertions.assertFalse(StringAide.isNoneLowerCase("ab1c"));
        Assertions.assertFalse(StringAide.isNoneLowerCase("ab/c"));
    }

    @Test
    public void testIsAllUpperCase() {
        Assertions.assertFalse(StringAide.isAllUpperCase(null));
        Assertions.assertFalse(StringAide.isAllUpperCase(""));
        Assertions.assertFalse(StringAide.isAllUpperCase("  "));
        Assertions.assertTrue(StringAide.isAllUpperCase("ABC"));
        Assertions.assertFalse(StringAide.isAllUpperCase("aBC"));
        Assertions.assertFalse(StringAide.isAllUpperCase("A C"));
        Assertions.assertFalse(StringAide.isAllUpperCase("A1C"));
        Assertions.assertFalse(StringAide.isAllUpperCase("A/C"));
    }

    @Test
    public void testIsAnyUpperCase() {
        Assertions.assertFalse(StringAide.isAnyUpperCase(null));
        Assertions.assertFalse(StringAide.isAnyUpperCase(""));
        Assertions.assertFalse(StringAide.isAnyUpperCase("  "));
        Assertions.assertFalse(StringAide.isAnyUpperCase("abc"));
        Assertions.assertFalse(StringAide.isAnyUpperCase("123"));
        Assertions.assertTrue(StringAide.isAnyUpperCase("ABC"));
        Assertions.assertTrue(StringAide.isAnyUpperCase("aBC"));
        Assertions.assertTrue(StringAide.isAnyUpperCase("A C"));
        Assertions.assertTrue(StringAide.isAnyUpperCase("A1C"));
        Assertions.assertTrue(StringAide.isAnyUpperCase("A/C"));
    }

    @Test
    public void testIsNoneUpperCase() {
        Assertions.assertTrue(StringAide.isNoneUpperCase(null));
        Assertions.assertTrue(StringAide.isNoneUpperCase(""));
        Assertions.assertTrue(StringAide.isNoneUpperCase("  "));
        Assertions.assertTrue(StringAide.isNoneUpperCase("abc"));
        Assertions.assertTrue(StringAide.isNoneUpperCase("123"));
        Assertions.assertFalse(StringAide.isNoneUpperCase("ABC"));
        Assertions.assertFalse(StringAide.isNoneUpperCase("aBC"));
        Assertions.assertFalse(StringAide.isNoneUpperCase("A C"));
        Assertions.assertFalse(StringAide.isNoneUpperCase("A1C"));
        Assertions.assertFalse(StringAide.isNoneUpperCase("A/C"));
    }

    @Test
    public void testIsMaxedCase() {
        Assertions.assertFalse(StringAide.isMixedCase(null));
        Assertions.assertFalse(StringAide.isMixedCase(""));
        Assertions.assertFalse(StringAide.isMixedCase("ABC"));
        Assertions.assertFalse(StringAide.isMixedCase("abc"));
        Assertions.assertTrue(StringAide.isMixedCase("aBc"));
        Assertions.assertTrue(StringAide.isMixedCase("A c"));
        Assertions.assertTrue(StringAide.isMixedCase("A1c"));
        Assertions.assertTrue(StringAide.isMixedCase("a/C"));
        Assertions.assertTrue(StringAide.isMixedCase("aC\t"));
    }

    @Test
    public void testIsAlpha() {
        Assertions.assertFalse(StringAide.isAlpha(null));
        Assertions.assertFalse(StringAide.isAlpha(""));
        Assertions.assertFalse(StringAide.isAlpha("  "));
        Assertions.assertTrue(StringAide.isAlpha("abc"));
        Assertions.assertFalse(StringAide.isAlpha("ab2c"));
        Assertions.assertFalse(StringAide.isAlpha("ab-c"));
    }

    @Test
    public void testIsAlphanumeric() {
        Assertions.assertFalse(StringAide.isAlphanumeric(null));
        Assertions.assertFalse(StringAide.isAlphanumeric(""));
        Assertions.assertFalse(StringAide.isAlphanumeric("  "));
        Assertions.assertTrue(StringAide.isAlphanumeric("abc"));
        Assertions.assertFalse(StringAide.isAlphanumeric("ab c"));
        Assertions.assertTrue(StringAide.isAlphanumeric("ab2c"));
        Assertions.assertFalse(StringAide.isAlphanumeric("ab-c"));
    }

    @Test
    public void testIsAlphaSpace() {
        Assertions.assertFalse(StringAide.isAlphaSpace(null));
        Assertions.assertTrue(StringAide.isAlphaSpace(""));
        Assertions.assertTrue(StringAide.isAlphaSpace("  "));
        Assertions.assertFalse(StringAide.isAlphaSpace("a\nc"));
        Assertions.assertTrue(StringAide.isAlphaSpace("abc"));
        Assertions.assertTrue(StringAide.isAlphaSpace("ab c"));
        Assertions.assertFalse(StringAide.isAlphaSpace("ab2c"));
        Assertions.assertFalse(StringAide.isAlphaSpace("ab-c"));
    }

    @Test
    public void testIsAlphaWhitespace() {
        Assertions.assertFalse(StringAide.isAlphaWhitespace(null));
        Assertions.assertTrue(StringAide.isAlphaWhitespace(""));
        Assertions.assertTrue(StringAide.isAlphaWhitespace("  "));
        Assertions.assertTrue(StringAide.isAlphaWhitespace("a\nb"));
        Assertions.assertTrue(StringAide.isAlphaWhitespace("abc"));
        Assertions.assertTrue(StringAide.isAlphaWhitespace("ab c"));
        Assertions.assertFalse(StringAide.isAlphaWhitespace("ab2c"));
        Assertions.assertFalse(StringAide.isAlphaWhitespace("ab-c"));
    }

    @Test
    public void testIsAlphanumericSpace() {
        Assertions.assertFalse(StringAide.isAlphanumericSpace(null));
        Assertions.assertTrue(StringAide.isAlphanumericSpace(""));
        Assertions.assertTrue(StringAide.isAlphanumericSpace("  "));
        Assertions.assertTrue(StringAide.isAlphanumericSpace("abc"));
        Assertions.assertTrue(StringAide.isAlphanumericSpace("ab c"));
        Assertions.assertTrue(StringAide.isAlphanumericSpace("ab2c"));
        Assertions.assertFalse(StringAide.isAlphanumericSpace("ab-c"));
    }

    @Test
    public void testIsNumeric() {
        Assertions.assertFalse(StringAide.isNumeric(null));
        Assertions.assertFalse(StringAide.isNumeric(""));
        Assertions.assertFalse(StringAide.isNumeric("  "));
        Assertions.assertTrue(StringAide.isNumeric("123"));
        Assertions.assertTrue(StringAide.isNumeric("१२३"));
        Assertions.assertFalse(StringAide.isNumeric("12 3"));
        Assertions.assertFalse(StringAide.isNumeric("ab2c"));
        Assertions.assertFalse(StringAide.isNumeric("12-3"));
        Assertions.assertFalse(StringAide.isNumeric("12.3"));
        Assertions.assertFalse(StringAide.isNumeric("-123"));
        Assertions.assertFalse(StringAide.isNumeric("+123"));
    }

    @Test
    public void testIsNumericSpace() {
        Assertions.assertFalse(StringAide.isNumericSpace(null));
        Assertions.assertTrue(StringAide.isNumericSpace(""));
        Assertions.assertTrue(StringAide.isNumericSpace("  "));
        Assertions.assertTrue(StringAide.isNumericSpace("123"));
        Assertions.assertTrue(StringAide.isNumericSpace("12 3"));
        Assertions.assertTrue(StringAide.isNumericSpace("\u0967\u0968\u0969"));
        Assertions.assertTrue(StringAide.isNumericSpace("\u0967\u0968 \u0969"));
        Assertions.assertFalse(StringAide.isNumericSpace("ab2c"));
        Assertions.assertFalse(StringAide.isNumericSpace("12-3"));
        Assertions.assertFalse(StringAide.isNumericSpace("12.3"));
    }

    @Test
    public void testIsNumericWhitespace() {
        Assertions.assertFalse(StringAide.isNumericWhitespace(null));
        Assertions.assertTrue(StringAide.isNumericWhitespace(""));
        Assertions.assertTrue(StringAide.isNumericWhitespace("  "));
        Assertions.assertTrue(StringAide.isNumericWhitespace("123"));
        Assertions.assertTrue(StringAide.isNumericWhitespace("12\n3"));
        Assertions.assertTrue(StringAide.isNumericWhitespace("12 3"));
        Assertions.assertTrue(StringAide.isNumericWhitespace("\u0967\u0968\u0969"));
        Assertions.assertTrue(StringAide.isNumericWhitespace("\u0967\u0968 \u0969"));
        Assertions.assertFalse(StringAide.isNumericWhitespace("ab2c"));
        Assertions.assertFalse(StringAide.isNumericWhitespace("12-3"));
        Assertions.assertFalse(StringAide.isNumericWhitespace("12.3"));
    }

    @Test
    public void testIsWhitespace() {
        Assertions.assertFalse(StringAide.isWhitespace(null));
        Assertions.assertTrue(StringAide.isWhitespace(""));
        Assertions.assertTrue(StringAide.isWhitespace("  "));
        Assertions.assertFalse(StringAide.isWhitespace("abc"));
        Assertions.assertFalse(StringAide.isWhitespace("ab2c"));
        Assertions.assertFalse(StringAide.isWhitespace("ab-c"));
    }

    @Test
    public void testIsAsciiPrintable() {
        Assertions.assertFalse(StringAide.isAsciiPrintable(null));
        Assertions.assertTrue(StringAide.isAsciiPrintable(""));
        Assertions.assertTrue(StringAide.isAsciiPrintable(" "));
        Assertions.assertTrue(StringAide.isAsciiPrintable("Ceki"));
        Assertions.assertTrue(StringAide.isAsciiPrintable("ab2c"));
        Assertions.assertTrue(StringAide.isAsciiPrintable("!ab-c~"));
        Assertions.assertTrue(StringAide.isAsciiPrintable("\u0020"));
        Assertions.assertTrue(StringAide.isAsciiPrintable("\u0021"));
        Assertions.assertTrue(StringAide.isAsciiPrintable("\u007e"));
        Assertions.assertFalse(StringAide.isAsciiPrintable("\u007f"));
        Assertions.assertFalse(StringAide.isAsciiPrintable("Ceki Gülcü"));
    }

    @Test
    public void build() {
        String str = "       StringAide.isAsciiPrintable(null)     = false\n" +
                "       StringAide.isAsciiPrintable(\"\")       = true\n" +
                "       StringAide.isAsciiPrintable(\" \")      = true\n" +
                "       StringAide.isAsciiPrintable(\"Ceki\")   = true\n" +
                "       StringAide.isAsciiPrintable(\"ab2c\")   = true\n" +
                "       StringAide.isAsciiPrintable(\"!ab-c~\") = true\n" +
                "       StringAide.isAsciiPrintable(\" \") = true\n" +
                "       StringAide.isAsciiPrintable(\"!\") = true\n" +
                "       StringAide.isAsciiPrintable(\"~\") = true\n" +
                "       StringAide.isAsciiPrintable(\"\u007F\") = false\n" +
                "       StringAide.isAsciiPrintable(\"Ceki Gülcü\") = false";
        try (BufferedReader reader = new BufferedReader(new StringReader(str))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                String[] sections = line.split("=");
                if ("true".equals(sections[1].trim())) {
                    System.out.println("Assertions.assertTrue(" + sections[0].trim() + ");");
                } else {
                    System.out.println("Assertions.assertFalse(" + sections[0].trim() + ");");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
