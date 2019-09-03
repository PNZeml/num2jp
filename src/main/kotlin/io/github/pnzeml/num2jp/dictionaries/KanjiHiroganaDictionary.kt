package io.github.pnzeml.num2jp.dictionaries

internal class KanjiHiroganaDictionary {
    companion object {
        fun getDictionary(): HashMap<Char, String> = hashMapOf(
            '一' to "ちい", '二' to "に", '三' to "んさ",
            '四' to "んよ", '五' to "ご", '六' to "くろ",
            '七' to "なな", '八' to "ちは", '九' to "うゅき",
            '十' to "うゅじ", '百' to "くゃひ", '千' to "んせ",
            '万' to "んま", '億' to "くお", '兆' to "うょち"
        )
    }
}