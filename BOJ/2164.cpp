#include <iostream>
using namespace std;

typedef struct a{
	int num;
	a* left;
	a* right;
	a() {}
	a(int n, a *l, a* r) {
		num = n;
		left = l;
		right = r;
	}
}node;

int N, sum;
node* arr[500001];

int main()
{
	scanf("%d", &N);
	int cur;
	sum = N;
	
	for (register int i = 1; i <= N; i++) arr[i] = new node(i, 0, 0);
	arr[1]->left = arr[1];
	arr[1]->right = arr[1];
	if (N != 1)
	{
		arr[1]->left = arr[N];
		arr[1]->right = arr[2];
		arr[N]->left = arr[N - 1];
		arr[N]->right = arr[1];
	}
	for (register int i = 2; i < N; i++)
	{
		arr[i]->left = arr[i - 1];
		arr[i]->right = arr[i + 1];
	}

	node* ptr = arr[1];

	while (sum > 2)
	{
		node* temp = ptr->right->right;
		ptr->left->right = ptr->right;
		ptr->right->left = ptr->left;
		delete ptr;
		sum--;
		ptr = temp;
	}

	printf("%d\n", ptr->right->num);
	node* temp = ptr->right;
	delete ptr;
	if(N != 1)delete temp;

	return 0;
}