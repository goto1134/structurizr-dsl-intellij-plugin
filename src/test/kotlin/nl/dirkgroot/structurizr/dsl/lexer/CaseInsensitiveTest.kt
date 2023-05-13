package nl.dirkgroot.structurizr.dsl.lexer

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import nl.dirkgroot.structurizr.dsl.psi.SDTypes.UNQUOTED_TEXT
import nl.dirkgroot.structurizr.dsl.support.tokenize

class CaseInsensitiveTest : StringSpec({
    "lexer is case insensitive" {
        "WoRKSpacE".tokenize() shouldContainExactly listOf(UNQUOTED_TEXT to "WoRKSpacE")
    }
})
