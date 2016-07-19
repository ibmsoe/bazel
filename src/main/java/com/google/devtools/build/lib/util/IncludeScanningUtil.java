// Copyright 2014 The Bazel Authors. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.devtools.build.lib.util;

import com.google.devtools.build.lib.vfs.PathFragment;

/**
 * Static utilities for include scanning.
 */
public class IncludeScanningUtil {
  private IncludeScanningUtil() {
  }

  private static final String INCLUDES_SUFFIX = ".includes";

  public static PathFragment getGreppedIncludes(String productName) {
    return new PathFragment(productName + "-out/_grepped_includes");
  }

  /**
   * Returns the exec-root relative output path for grepped includes.
   *
   * @param srcExecPath the exec-root relative path of the source file.
   */
  public static PathFragment getExecRootRelativeOutputPath(PathFragment srcExecPath,
      String productName) {
    return getGreppedIncludes(productName).getRelative(getRootRelativeOutputPath(srcExecPath));
  }

  /**
   * Returns the root relative output path for grepped includes.
   *
   * @param srcExecPath the exec-root relative path of the source file.
   */
  public static PathFragment getRootRelativeOutputPath(PathFragment srcExecPath) {
    return srcExecPath.replaceName(srcExecPath.getBaseName() + INCLUDES_SUFFIX);
  }
}
