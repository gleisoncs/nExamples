package com.examples.createannotation;

@Huep(priority = Huep.Priority.HIGH, createdBy = "caetano.com", tags = { "sales", "test" })
public class SomeClass {

	@HuepInfo
	void testA() {
		if (true)
			throw new RuntimeException("This test always failed");
	}

	@HuepInfo(enabled = false)
	void testB() {
		if (false)
			throw new RuntimeException("This test always passed");
	}

	@HuepInfo(enabled = true)
	void testC() {
		if (10 > 1) {
			// do nothing, this test always passed.
		}
	}

}