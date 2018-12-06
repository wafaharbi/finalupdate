package com.example.wafa.studentapp;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ImageSpan;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;


public class TextJustification {

    public static void justify(final TextView textView) {

        // the post callback will continue to fire after processing
        final AtomicBoolean isJustify = new AtomicBoolean(false);

      // raw string before processing
        final String textString = textView.getText().toString();

    //used to measure the width of the text, calculate the width of the space after the scattered alignment
        final TextPaint textPaint = textView.getPaint();

        CharSequence textViewText = textView.getText();

        // Distribute the aligned text
        final Spannable builder = textViewText instanceof Spannable ?
                (Spannable) textViewText :
                new SpannableString(textString);

       // Execute after the TextView has finished measuring the drawing
        textView.post(new Runnable() {
            @Override
            public void run() {

                // Determine whether it has been processed
                if (!isJustify.get()) {

                    // Get the total number of rows in the original layout
                    final int lineCount = textView.getLineCount();
                    //Get the width of the textView
                    final int textViewWidth = textView.getWidth();

                    for (int i = 0; i < lineCount; i++) {

                        // Get the first character position and the end character position of the line to intercept the text of each line
                        int lineStart = textView.getLayout().getLineStart(i);
                        int lineEnd = textView.getLayout().getLineEnd(i);

                        String lineString = textString.substring(lineStart, lineEnd);

                        // The last line is not processed
                        if (i == lineCount - 1) {
                            break;
                        }

                        // Remove the spaces at the end of the line to ensure the alignment after processing
                        String trimSpaceText = lineString.trim();
                        String removeSpaceText = lineString.replaceAll(" ", "");

                        float removeSpaceWidth = textPaint.measureText(removeSpaceText);
                        float spaceCount = trimSpaceText.length() - removeSpaceText.length();

                        // Recalculated width of each space when justified
                        float eachSpaceWidth = (textViewWidth - removeSpaceWidth) / spaceCount;

                        // Both ends of the space need to be handled separately
                        Set<Integer> endsSpace = spacePositionInEnds(lineString);
                        for (int j = 0; j < lineString.length(); j++) {
                            char c = lineString.charAt(j);

                            // Use a transparent drawable to fill the space part
                            Drawable drawable = new ColorDrawable(0x00ffffff);

                            if (c == ' ') {
                                if (endsSpace.contains(j)) {
                                    // If it is a space at both ends, the width is set to 0
                                    drawable.setBounds(0, 0, 0, 0);
                                } else {
                                    drawable.setBounds(0, 0, (int) eachSpaceWidth, 0);
                                }
                                ImageSpan span = new ImageSpan(drawable);
                                builder.setSpan(span, lineStart + j, lineStart + j + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                            }
                        }
                    }

                    textView.setText(builder);
                    // The tag is processed
                    isJustify.set(true);
                }
            }
        });
    }
/*
    Returns the space coordinates at both ends,
    such as the string " abc " (one space before, two spaces after it) returns [0, 5, 6]*/

    private static Set<Integer> spacePositionInEnds(String string) {
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c == ' ') {
                result.add(i);
            } else {
                break;
            }
        }

        if (result.size() == string.length()) {
            return result;
        }

        for (int i = string.length() - 1; i > 0; i--) {
            char c = string.charAt(i);
            if (c == ' ') {
                result.add(i);
            } else {
                break;
            }
        }

        return result;
    }
}
