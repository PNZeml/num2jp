package ru.jr2.num2jp

fun String.getNumberInKanji(): String {
    val strBuilder = StringBuilder()
    var chunkCounter = 0
    var interCounter = 0
    for (idx in this.length - 1 downTo 0) {
        // Check if need to insert 万, 億, 兆, etc.
        if (chunkCounter == 0) {
            // Check if the next chunk is equal to 0
            var isChunkEqO = this[idx] == '0'
            if (idx - 1 >= 0) isChunkEqO = this[idx - 1] == '0' && isChunkEqO
            if (idx - 2 >= 0) isChunkEqO = this[idx - 2] == '0' && isChunkEqO
            if (idx - 3 >= 0) isChunkEqO = this[idx - 3] == '0' && isChunkEqO
            if (!isChunkEqO) when (interCounter) {
                1 -> strBuilder.append(numToKanjiNum['A'])
                2 -> strBuilder.append(numToKanjiNum['B'])
                3 -> strBuilder.append(numToKanjiNum['C'])
            }
        }
        // Insert current char
        if (this[idx] != '0') {
            // Check if need to insert 十, 百, 千
            when (chunkCounter) {
                1 -> strBuilder.append(numToKanjiNum['a'])
                2 -> strBuilder.append(numToKanjiNum['b'])
                3 -> strBuilder.append(numToKanjiNum['c'])
            }
            // Check if need to insert 一
            if (this[idx] != '1' || chunkCounter == 0) {
                strBuilder.append(numToKanjiNum[this[idx]])
            }
        }
        chunkCounter++

        if (chunkCounter == 4) {
            chunkCounter = 0
            interCounter++
        }
    }
    return strBuilder.reverse().toString()
}

fun String.getNumberInKatakana(): String {
    val strBuilder = StringBuilder()
    val strKata = this.getNumberInKanji()
    var isSpecialTriggered = false
    var specialCounter = 0
    for (idx in strKata.length - 1 downTo 0) {
        // Check if the next two chars are special case
        if (idx - 1 >= 0) {
            kanjiToKatakanaNumSpecial["${strKata[idx]}${strKata[idx - 1]}"]?.run {
                strBuilder.append(this)
                isSpecialTriggered = true
                specialCounter = 2
            }
        }
        if (isSpecialTriggered) when(specialCounter) {
            1, 2 -> specialCounter--
            0 -> isSpecialTriggered = false
        }
        if (!isSpecialTriggered) {
            // Insert converted char
            kanjiToKatakanaNum[strKata[idx]]?.run { strBuilder.append(this) }
        }
    }
    return strBuilder.reverse().toString()
}

fun String.getNumberInRomanzi() {
    throw NotImplementedError()
}