package io.github.pnzeml.num2jp

internal val numToKanjiNum: HashMap<Char, Char> = hashMapOf(
    '1' to '一',
    '2' to '二',
    '3' to '三',
    '4' to '四',
    '5' to '五',
    '6' to '六',
    '7' to '七',
    '8' to '八',
    '9' to '九',
    'a' to '十',
    'b' to '百',
    'c' to '千',
    'A' to '万',
    'B' to '億',
    'C' to '兆'
)

// inverted values
internal val kanjiToKatakanaNum: HashMap<Char, String> = hashMapOf(
    '一' to "ちい",
    '二' to "に",
    '三' to "んさ",
    '四' to "んよ",
    '五' to "ご",
    '六' to "くろ",
    '七' to "なな",
    '八' to "ちは",
    '九' to "うゅき",
    '十' to "うゅじ",
    '百' to "くゃひ",
    '千' to "んせ",
    '万' to "んま",
    '億' to "くお",
    '兆' to "うょち"
)

// inverted values
internal val kanjiToKatakanaNumSpecial: HashMap<String, String> = hashMapOf(
    "百三" to "くゃびんさ",
    "百六" to "くゃぴっろ",
    "百八" to "くゃぴっは",
    "千三" to "んぜんさ",
    "千八" to "んせっは"
)