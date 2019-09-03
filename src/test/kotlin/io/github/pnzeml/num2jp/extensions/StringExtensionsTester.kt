package io.github.pnzeml.num2jp.extensions

import io.kotlintest.data.forall
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.row

class StringExtensionsTester : StringSpec({
    "convert numeric string to kanji string" {
        forall(
            row("1", "一"),
            row("10", "十"),
            row("11", "十一"),
            row("5555", "五千五百五十五"),
            row("10555", "一万五百五十五"),
            row("123456789123", "千二百三十四億五千六百七十八万九千百二十三")
        ) { a, b ->
            a.numberToKanji() shouldBe b
        }
    }

    "convert numeric string to hirogana string" {
        forall(
            row("1", "いち"),
            row("10", "じゅう"),
            row("11", "じゅういち"),
            row("5555", "ごせんごひゃくごじゅうご"),
            row("10555", "いちまんごひゃくごじゅうご"),
            row(
                "123456789123",
                "せんにひゃくさんじゅうよんおくごせんろっぴゃくななじゅうはちまんきゅうせんひゃくにじゅうさん"
            )
        ) { a, b ->
            a.numberToHirogana() shouldBe b
        }
    }
})