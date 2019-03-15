package io.github.pnzeml.num2jp

import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    @Test
    fun `convert numeric string to kanji string`() {
        val conv1 = "1".getNumberInKanji()
        assertEquals(conv1, "一")

        val conv2 = "10".getNumberInKanji()
        assertEquals(conv2, "十")

        val conv3 = "11".getNumberInKanji()
        assertEquals(conv3, "十一")

        val conv4 = "5555".getNumberInKanji()
        assertEquals(conv4, "五千五百五十五")

        val conv5 = "10555".getNumberInKanji()
        assertEquals(conv5, "一万五百五十五")

        val conv6 = "123456789123".getNumberInKanji()
        assertEquals(conv6, "千二百三十四億五千六百七十八万九千百二十三")
    }

    @Test
    fun `convert numeric string to hirogana string`() {
        val conv1 = "1".getNumberInKatakana()
        assertEquals(conv1, "いち")

        val conv2 = "10".getNumberInKatakana()
        assertEquals(conv2, "じゅう")

        val conv3 = "11".getNumberInKatakana()
        assertEquals(conv3, "じゅういち")

        val conv4 = "5555".getNumberInKatakana()
        assertEquals(conv4, "ごせんごひゃくごじゅうご")

        val conv5 = "10555".getNumberInKatakana()
        assertEquals(conv5, "いちまんごひゃくごじゅうご")

        val conv6 = "123456789123".getNumberInKatakana()
        assertEquals(conv6, "せんにひゃくさんじゅうよんおくごせんろっぴゃくななじゅうはちまんきゅうせんひゃくにじゅうさん")
    }
}