package io.github.pnzeml.num2jp.extensions

import io.github.pnzeml.num2jp.dictionaries.KanjiHiroganaDictionary
import io.github.pnzeml.num2jp.dictionaries.KanjiHiroganaSpecialDictionary
import io.github.pnzeml.num2jp.dictionaries.NumberKanjiDictionary

fun String.numberToKanji(): String {
    val numberKanjiDictionary = NumberKanjiDictionary.getDictionary()

    val stringBuilder = StringBuilder()
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
                1 -> stringBuilder.append(numberKanjiDictionary['d'])
                2 -> stringBuilder.append(numberKanjiDictionary['e'])
                3 -> stringBuilder.append(numberKanjiDictionary['f'])
            }
        }
        // Insert current char
        if (this[idx] != '0') {
            // Check if need to insert 十, 百, 千
            when (chunkCounter) {
                1 -> stringBuilder.append(numberKanjiDictionary['a'])
                2 -> stringBuilder.append(numberKanjiDictionary['b'])
                3 -> stringBuilder.append(numberKanjiDictionary['c'])
            }
            // Check if need to insert 一
            if (this[idx] != '1' || chunkCounter == 0) {
                stringBuilder.append(numberKanjiDictionary[this[idx]])
            }
        }
        chunkCounter++

        if (chunkCounter == 4) {
            chunkCounter = 0
            interCounter++
        }
    }
    return stringBuilder.reverse().toString()
}

fun String.numberToHirogana(): String {
    val kanjiHiroganaDictionary = KanjiHiroganaDictionary.getDictionary()
    val kanjiHiroganaSpecialDictionary = KanjiHiroganaSpecialDictionary.getDictionary()

    val stringBuilder = StringBuilder()
    val strKata = this.numberToKanji()
    var isSpecialCharEncountered = false
    var nextSpecialCharCounter = 0

    for (idx in strKata.length - 1 downTo 0) {
        // Check if the next two chars are special case
        if (idx - 1 >= 0) {
            kanjiHiroganaSpecialDictionary["${strKata[idx]}${strKata[idx - 1]}"]?.run {
                stringBuilder.append(this)
                isSpecialCharEncountered = true
                nextSpecialCharCounter = 2
            }
        }
        if (isSpecialCharEncountered) when (nextSpecialCharCounter) {
            1, 2 -> nextSpecialCharCounter--
            0 -> isSpecialCharEncountered = false
        }
        if (!isSpecialCharEncountered) {
            // Insert converted char
            kanjiHiroganaDictionary[strKata[idx]]?.run {
                stringBuilder.append(this)
            }
        }
    }
    return stringBuilder.reverse().toString()
}

fun String.numberToRomanzi() {
    throw NotImplementedError()
}