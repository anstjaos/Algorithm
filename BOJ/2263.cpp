#include <stdio.h>
#define MAX_SIZE 100001

int inorder[MAX_SIZE], postOrder[MAX_SIZE], N;
int idx[MAX_SIZE];

void preOrder(int inBegin, int inEnd, int postBegin, int postEnd)
{
	if (inBegin > inEnd || postBegin > postEnd)
		return;

	int root = postOrder[postEnd];
	printf("%d ", root);

	preOrder(inBegin, idx[root] - 1, postBegin, postBegin + (idx[root] - inBegin) - 1);
	preOrder(idx[root] + 1, inEnd, postBegin + (idx[root] - inBegin), postEnd - 1);
}

int main(void)
{
	scanf("%d", &N);

	for (int i = 0; i < N; i++) scanf("%d", inorder + i);
	for (int i = 0; i < N; i++) scanf("%d", postOrder + i);
	for (int i = 0; i < N; i++) idx[inorder[i]] = i;

	preOrder(0, N - 1, 0, N - 1);
	printf("\n");

	return 0;
}