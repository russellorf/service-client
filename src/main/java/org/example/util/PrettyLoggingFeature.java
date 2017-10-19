package org.example.util;

import org.apache.cxf.feature.LoggingFeature;

public class PrettyLoggingFeature extends LoggingFeature {

	public PrettyLoggingFeature() {
		super.setPrettyLogging(true);
	}
}