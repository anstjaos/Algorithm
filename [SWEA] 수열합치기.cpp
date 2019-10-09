#include <iostream>
#include <stdio.h>

using namespace std;

//////////////////////////////////////////////
#define MAX_SIZE 1000005

struct Node {
	int num;
	Node* left;
	Node* right;
};

Node* first;
Node* tail;
Node nodePool[MAX_SIZE];
int poolCount;

void init()
{
	Node temp = { 0, 0, 0 };
	for (register int i = 0; i < poolCount; i++) nodePool[i] = temp;
	first = &nodePool[0];
	tail = &nodePool[0];
	poolCount = 1;
}

void mergenums(int n, int* arr)
{
	nodePool[poolCount] = { arr[0], 0, 0 };
	Node* newFirst = &nodePool[poolCount];
	Node* newTail = &nodePool[poolCount++];

	for (register int i = 1; i < n; i++) {
		nodePool[poolCount] = { arr[i], newTail, 0 };
		newTail->right = &nodePool[poolCount];
		newTail = &nodePool[poolCount++];
	}

	Node* ptr = first;
	while (ptr != 0)
	{
		if (ptr->num > arr[0]) break;
		ptr = ptr->right;
	}

	if (ptr == 0)
	{
		newFirst->left = tail;
		tail->right = newFirst;
		tail = newTail;
	}
	else
	{
		newFirst->left = ptr->left;
		ptr->left->right = newFirst;
		ptr->left = newTail;
		newTail->right = ptr;
	}
}

int findkth(int kth)
{
	Node* ptr = 0;
	int ret = 0;

	if (kth > 0) {
		ptr = first->right;
		kth--;
		while (kth != 0)
		{
			ptr = ptr->right;
			kth--;
		}
		ret = ptr->num;
	}
	else {
		ptr = tail;
		kth *= -1;
		kth--;
		while (kth != 0)
		{
			ptr = ptr->left;
			kth--;
		}
		ret = ptr->num;
	}
	return ret;
}
///////////////////////////////////////////////

int main()
{
	//	freopen("input.txt", "r", stdin);

	int totalscore = 0;
	int score = 100;
	int fail;
	int inputnums[1000];

	int TC;
	cin >> TC;
	for (int tc = 1; tc <= TC; tc++)
	{
		fail = 0;

		init();

		int tcnt;
		cin >> tcnt;
		for (int j = 0; j < tcnt; j++)
		{
			char op;
			cin >> op;
			switch (op)
			{
			case 'M':
				int numscnt;
				cin >> numscnt;
				for (int k = 0; k < numscnt; k++)
				{
					cin >> inputnums[k];
				}
				mergenums(numscnt, inputnums);
				break;

			case 'K':
				int kth, tans;
				cin >> kth >> tans;
				if (findkth(kth) != tans)
					fail = 1;
				break;
			}
		}
		if (fail) printf("#%d 0\n", tc);
		else
		{
			printf("#%d 100\n", tc);
			totalscore += score;
		}
	}
	printf("Total Score = %d\n", totalscore / TC);
	return 0;
}