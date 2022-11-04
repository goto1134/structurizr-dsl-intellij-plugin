package nl.dirkgroot.structurizr.dsl

import assertk.assertThat
import assertk.assertions.isEmpty
import assertk.assertions.isFailure
import assertk.assertions.isNotEmpty
import com.intellij.psi.PsiErrorElement
import com.intellij.psi.tree.TokenSet
import com.intellij.testFramework.ParsingTestCase
import nl.dirkgroot.structurizr.dsl.lang.StructurizrDSLParserDefinition
import nl.dirkgroot.structurizr.dsl.psi.SDFile
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
abstract class StructurizrDSLParserTest : ParsingTestCase("parser", "dsl", StructurizrDSLParserDefinition()) {
    protected fun assertParseSucceeds(source: String): SDFile {
        val psiFile = parseFile("test.dsl", source)
        val root = psiFile.viewProvider.allFiles.first()

        assertThat(
            root.node.getChildren(TokenSet.ANY)
                .filterIsInstance<PsiErrorElement>()
        ).isEmpty()

        return root as SDFile
    }

    protected fun assertParseFails(source: String) {
        val psiFile = parseFile("test.dsl", source)

        val root = psiFile.viewProvider.allFiles.first()

        assertThat(
            root.node.getChildren(TokenSet.ANY)
                .filterIsInstance<PsiErrorElement>()
        ).isNotEmpty()
    }

    override fun getTestDataPath(): String {
        return "src/test/testData"
    }

    override fun skipSpaces(): Boolean {
        return false
    }

    override fun includeRanges(): Boolean {
        return true
    }
}
