#include <iostream>
using namespace std;

typedef struct a{
	int num;
	a* left;
	a* right;

	a() {}
	a(int i_num, a* i_left, a* i_right) {
		num = i_num;
		left = i_left;
		right = i_right;
	}
}node;

node *nodePool[100];
node *curPtr;
int N, M, num, sum;

int min(int a, int b) { return (a < b ? a : b); }

int leftMove()
{
	int cnt = 0;
	node *temp = curPtr;

	while (temp->num != num) {
		temp = temp->left;
		cnt++;
	}

	return cnt;
}

int rightMove()
{
	int cnt = 0;
	node *temp = curPtr;
	
	while (temp->num != num) {
		temp = temp->right;
		cnt++;
	}

	return cnt;
}

void init()
{
	nodePool[0] = new node(0, 0, 0);
	nodePool[0]->left = nodePool[0];
	nodePool[0]->right = nodePool[0];

	for (int i = 1; i <= N; i++) {
		nodePool[i] = new node(i, nodePool[0], nodePool[0]);
	}

	nodePool[1]->left = nodePool[N];
	nodePool[1]->right = nodePool[2];
	
	nodePool[N]->right = nodePool[1];
	nodePool[N]->left = nodePool[N - 1];

	for (int i = 2; i < N; i++) {
		nodePool[i]->left = nodePool[i - 1];
		nodePool[i]->right = nodePool[i + 1];
	}
}

void deleteNode()
{
	for (int i = 1; i <= N; i++) {
		delete nodePool[i];
	}
}

int main()
{
	scanf("%d %d", &N, &M);
	init();
	curPtr = nodePool[1];
	for (register int i = 0; i < M; i++) {
		scanf("%d", &num);

		int cnt = 0;
		if (num != curPtr->num)
		{
			cnt = min(leftMove(), rightMove());

			curPtr = nodePool[num]->right;
		}
		else curPtr = curPtr->right;

		nodePool[num]->right->left = nodePool[num]->left;
		nodePool[num]->left->right = nodePool[num]->right;
		sum += cnt;
	}
	printf("%d\n", sum);
	deleteNode();
	return 0;
}