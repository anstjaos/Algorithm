#include <iostream>
using namespace std;

int arr[100001], n, preOrder[100001], postOrder[100001];
int index = 1;

void solve(int curIndex)
{
	if (curIndex * 2 <= n) solve(curIndex * 2);
	arr[curIndex] = preOrder[index++];
	if (curIndex * 2 + 1 <= n) solve(curIndex * 2 + 1);
}

void showPreOrder(int curIndex)
{
	cout << arr[curIndex] << " ";
	if (curIndex * 2 <= n) showPreOrder(curIndex * 2);
	if (curIndex * 2 + 1 <= n) showPreOrder(curIndex * 2 + 1);
}

int main()
{
	cin >> n;

	for (int i = 1; i <= n; i++)
	{
		cin >> preOrder[i];
	}
	for (int i = 1; i <= n; i++) cin >> postOrder[i];

	solve(1);
	showPreOrder(1);
	cout << '\n';
	return 0;
}