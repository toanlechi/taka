package vn.magik.hometest;

import org.junit.Test;

import vn.magik.hometest.helpers.CalculatorTextHelper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Test function format word.
 * If the keyword is more than one word, then display in two lines.
 * These two lines should have minimum difference in length.
 */
public class FormatWordTest {

    @Test
    public void formatOneWord_isCorrect() {
        assertEquals("sách", CalculatorTextHelper.formatWord("sách "));
        assertEquals("sách", CalculatorTextHelper.formatWord("sách"));
        assertEquals("sách", CalculatorTextHelper.formatWord(" sách"));
    }

    @Test
    public void formatWordNull_isCorrect() {
        String word = null;
        assertEquals("", CalculatorTextHelper.formatWord(word));
    }

    @Test
    public void formatWordMulti_isCorrect() {
        assertEquals("Android\nStudio", CalculatorTextHelper.formatWord("Android Studio"));
        assertEquals("Nguyễn\nNhật Ánh", CalculatorTextHelper.formatWord("Nguyễn Nhật Ánh"));
        assertEquals("tai nghe\nbluetooth", CalculatorTextHelper.formatWord("tai nghe bluetooth"));
        assertEquals("Tuổi trẻ đáng\ngiá bao nhiêu", CalculatorTextHelper.formatWord("Tuổi trẻ đáng giá bao nhiêu"));
        assertEquals("Điện thoại\niPhone X", CalculatorTextHelper.formatWord("Điện thoại iPhone X"));
    }

    @Test
    public void formatWordMulti_error() {
        assertNotEquals("Nguyễn Nhật\nÁnh", CalculatorTextHelper.formatWord("Nguyễn Nhật Ánh"));
        assertNotEquals("Chuột không\ndây", CalculatorTextHelper.formatWord("Chuột không dây"));
        assertNotEquals("Ly\ngiữ nhiệt", CalculatorTextHelper.formatWord("Ly giữ nhiệt"));
    }
}
