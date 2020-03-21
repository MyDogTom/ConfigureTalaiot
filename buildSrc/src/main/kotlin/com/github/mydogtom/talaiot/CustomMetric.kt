package com.github.mydogtom.talaiot

import com.cdsap.talaiot.metrics.base.GradleMetric

class ProjectFolderMetric : GradleMetric<String>(
    provider = { it.rootDir.absolutePath },
    assigner = { report, value -> report.customProperties.buildProperties["projectFolder"] = value }
)

private const val KEY_ANDROID_STUDIO = "android.injected.invoked.from.ide"

class AndroidStudioMetric : GradleMetric<String>(
    provider = { it.gradle.rootProject.hasProperty(KEY_ANDROID_STUDIO).toString() },
    assigner = { report, value ->
        report.customProperties.buildProperties["fromAndroidStudio"] = value
    }
)
