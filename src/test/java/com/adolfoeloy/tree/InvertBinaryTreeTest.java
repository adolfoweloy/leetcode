package com.adolfoeloy.tree;

import com.adolfoeloy.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InvertBinaryTreeTest {
    private final InvertBinaryTree subject = new InvertBinaryTree();

    @Test
    void test1() {
        TreeNode input = new TreeNode(4,
            new TreeNode(2,
                    new TreeNode(1),
                    new TreeNode(3)),
            new TreeNode(7,
                    new TreeNode(6),
                    new TreeNode(9))
        );

        TreeNode output = subject.invertTree(input);
        assertThat(output.toArray()).isEqualTo(new int[] {4,7,2,9,6,3,1});
    }

    @Test
    void test2() {
        TreeNode input = new TreeNode(2,
                new TreeNode(1),
                new TreeNode(3)
        );

        TreeNode output = subject.invertTree(input);
        assertThat(output.toArray()).isEqualTo(new int[] {2,3,1});
    }

}