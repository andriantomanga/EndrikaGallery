/**
 * Copyright (c) 2024 Nabil Andriantomanga
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.endrikagallery.utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 * @author Nabil Andriantomanga
 * @version 1.0
 * @since 2024
 */
public final class DrawingUtil {
    private DrawingUtil() {
    }

    public static void drawArrow(Graphics2D g, Point source, Point dest, Color color, int strokeWidth) {
        g.setColor(color);
        g.setStroke(new BasicStroke(strokeWidth));
        g.drawLine(source.x, source.y, dest.x, dest.y);

        // Calculate the angle of the arrow
        var angle = Math.atan2(dest.y - source.y, dest.x - source.x);

        // Length of the arrowhead lines
        var arrowHeadLength = 10;
        var arrowHeadWidth = 7;

        // Calculate the coordinates for the arrowhead
        var x1 = (int) (dest.x - arrowHeadLength * Math.cos(angle - Math.PI / 6));
        var y1 = (int) (dest.y - arrowHeadLength * Math.sin(angle - Math.PI / 6));
        var x2 = (int) (dest.x - arrowHeadLength * Math.cos(angle + Math.PI / 6));
        var y2 = (int) (dest.y - arrowHeadLength * Math.sin(angle + Math.PI / 6));

        // Draw the arrowhead
        g.drawLine(dest.x, dest.y, x1, y1);
        g.drawLine(dest.x, dest.y, x2, y2);
    }
}
