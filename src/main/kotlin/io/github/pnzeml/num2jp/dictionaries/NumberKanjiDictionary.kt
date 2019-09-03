package io.github.pnzeml.num2jp.dictionaries

internal class NumberKanjiDictionary {
    companion object {
        fun getDictionary(): HashMap<Char, Char> = hashMapOf(
            '1' to '一', '2' to '二', '3' to '三',
            '4' to '四', '5' to '五', '6' to '六',
            '7' to '七', '8' to '八', '9' to '九',
            'a' to '十', 'b' to '百', 'c' to '千',
            'd' to '万', 'e' to '億', 'f' to '兆'
        )
    }
}