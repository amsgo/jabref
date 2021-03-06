package org.jabref.model.entry.identifier;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArXivIdentifierTest {

    @Test
    void parse() throws Exception {
        Optional<ArXivIdentifier> parsed = ArXivIdentifier.parse("0710.0994");

        assertEquals(Optional.of(new ArXivIdentifier("0710.0994")), parsed);
    }

    @Test
    void parseWithArXivPrefix() throws Exception {
        Optional<ArXivIdentifier> parsed = ArXivIdentifier.parse("arXiv:0710.0994");

        assertEquals(Optional.of(new ArXivIdentifier("0710.0994")), parsed);
    }

    @Test
    void parseWithArxivPrefix() throws Exception {
        Optional<ArXivIdentifier> parsed = ArXivIdentifier.parse("arxiv:0710.0994");

        assertEquals(Optional.of(new ArXivIdentifier("0710.0994")), parsed);
    }

    @Test
    void parseWithClassification() throws Exception {
        Optional<ArXivIdentifier> parsed = ArXivIdentifier.parse("0706.0001v1 [q-bio.CB]");

        assertEquals(Optional.of(new ArXivIdentifier("0706.0001", "1", "q-bio.CB")), parsed);
    }

    @Test
    void parseWithArXivPrefixAndClassification() throws Exception {
        Optional<ArXivIdentifier> parsed = ArXivIdentifier.parse("arXiv:0706.0001v1 [q-bio.CB]");

        assertEquals(Optional.of(new ArXivIdentifier("0706.0001", "1", "q-bio.CB")), parsed);
    }

    @Test
    void parseOldIdentifier() throws Exception {
        Optional<ArXivIdentifier> parsed = ArXivIdentifier.parse("math.GT/0309136");

        assertEquals(Optional.of(new ArXivIdentifier("math.GT/0309136", "math.GT")), parsed);
    }

    @Test
    void parseOldIdentifierWithArXivPrefix() throws Exception {
        Optional<ArXivIdentifier> parsed = ArXivIdentifier.parse("arXiv:math.GT/0309136");

        assertEquals(Optional.of(new ArXivIdentifier("math.GT/0309136", "math.GT")), parsed);
    }

    @Test
    void parseUrl() throws Exception {
        Optional<ArXivIdentifier> parsed = ArXivIdentifier.parse("http://arxiv.org/abs/1502.05795");

        assertEquals(Optional.of(new ArXivIdentifier("1502.05795", "")), parsed);
    }

    @Test
    void parseHttpsUrl() throws Exception {
        Optional<ArXivIdentifier> parsed = ArXivIdentifier.parse("https://arxiv.org/abs/1502.05795");

        assertEquals(Optional.of(new ArXivIdentifier("1502.05795", "")), parsed);
    }

    @Test
    void parsePdfUrl() throws Exception {
        Optional<ArXivIdentifier> parsed = ArXivIdentifier.parse("http://arxiv.org/pdf/1502.05795");

        assertEquals(Optional.of(new ArXivIdentifier("1502.05795", "")), parsed);
    }

    @Test
    void parseUrlWithVersion() throws Exception {
        Optional<ArXivIdentifier> parsed = ArXivIdentifier.parse("http://arxiv.org/abs/1502.05795v1");

        assertEquals(Optional.of(new ArXivIdentifier("1502.05795", "1", "")), parsed);
    }

    @Test
    void parseOldUrlWithVersion() throws Exception {
        Optional<ArXivIdentifier> parsed = ArXivIdentifier.parse("http://arxiv.org/pdf/hep-ex/0307015v1");

        assertEquals(Optional.of(new ArXivIdentifier("hep-ex/0307015", "1", "hep-ex")), parsed);
    }
}
