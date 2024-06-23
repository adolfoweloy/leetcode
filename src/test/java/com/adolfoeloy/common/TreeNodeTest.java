package com.adolfoeloy.common;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TreeNodeTest {

    @Test
    void toArray_should_return_an_array_with_one_node() {
        TreeNode root = new TreeNode(4);
        int[] output = root.toArray();
        assertThat(output).isEqualTo(new int[] {4});
    }

    @Test
    void toArray_should_return_an_array_with_root_and_children() {
        TreeNode root = new TreeNode(4,
                new TreeNode(2),
                new TreeNode(7)
        );
        int[] output = root.toArray();
        assertThat(output).isEqualTo(new int[] {4, 2, 7});
    }
}