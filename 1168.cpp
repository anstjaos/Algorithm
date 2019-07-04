#include <stdio.h>
#define MAX_SIZE 100001

typedef struct Node {
	int num;
	Node* left;
	Node* right;
}Node;

Node nodePool[MAX_SIZE];
int N, K, poolCnt;

int main()
{
	scanf("%d %d", &N, &K);
	for (register int i = 1; i <= N; i++) {
		nodePool[poolCnt].num = i;
		if (i != 1) nodePool[poolCnt].left = &nodePool[poolCnt - 1];
		if (i != N) nodePool[poolCnt].right = &nodePool[poolCnt + 1];

		poolCnt++;
	}
	nodePool[poolCnt - 1].right = &nodePool[0];
	nodePool[0].left = &nodePool[poolCnt - 1];

	Node* ptr = &nodePool[0];
	printf("<");
	for (register int i = 0; i < K - 1; i++) {
		ptr = ptr->right;
	}

	printf("%d, ", ptr->num);
	ptr->left->right = ptr->right;
	ptr->right->left = ptr->left;
	N--;
	while (N > 1) {
		for (register int i = 0; i < K; i++) {
			ptr = ptr->right;
		}

		printf("%d, ", ptr->num);
		ptr->left->right = ptr->right;
		ptr->right->left = ptr->left;
		N--;
	}
	ptr = ptr->right;
	printf("%d>\n", ptr->num);
	return 0;
}