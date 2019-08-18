#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

int N, M, K, a, b, c;
long long d;

long long init(vector<long long> &arr, vector<long long> &tree, int index, int start, int end)
{
	if (start == end) return tree[index] = arr[start];

	return tree[index] = init(arr, tree, index * 2, start, (start + end) / 2) + init(arr, tree, index * 2 + 1, (start + end) / 2 + 1, end);
}

void update_razy(vector<long long> &tree, vector<long long> &lazy, int index, int start, int end)
{
	if (lazy[index] != 0)
	{
		tree[index] += (end - start + 1) * lazy[index];

		if (start != end)
		{
			lazy[index * 2] += lazy[index];
			lazy[index * 2 + 1] += lazy[index];
		}

		lazy[index] = 0;
	}
}

void update_range(vector<long long> &tree, vector<long long> &lazy, int index, int start, int end, int left, int right, long long differ)
{
	update_razy(tree, lazy, index, start, end);
	if (left > end || right < start) return;

	if (left <= start && end <= right)
	{
		tree[index] += (end - start + 1) * differ;
		if (start != end)
		{
			lazy[index * 2] += differ;
			lazy[index * 2 + 1] += differ;
		}
		return;
	}

	update_range(tree, lazy, index * 2, start, (start + end) / 2, left, right, differ);
	update_range(tree, lazy, index * 2 + 1, (start + end) / 2 + 1, end, left, right, differ);
	tree[index] = tree[index * 2] + tree[index * 2 + 1];
}

long long sum(vector<long long> &tree, vector<long long> &lazy, int index, int start, int end, int left, int right)
{
	update_razy(tree, lazy, index, start, end);

	if (left > end || right < start) return 0;
	if (left <= start && end <= right) return tree[index];

	return sum(tree, lazy, index * 2, start, (start + end) / 2, left, right) + sum(tree, lazy, index * 2 + 1, (start + end) / 2 + 1, end, left, right);
}

int main()
{
	cin >> N >> M >> K;
	vector<long long> arr(N);
	int height = (int)ceil(log2(N));
	int treeSize = (1 << (height+1)) - 1;

	for (int i = 0; i < N; i++) cin >> arr[i];
	vector<long long> tree(treeSize);
	vector<long long> lazy(treeSize);

	init(arr, tree, 1, 0, N - 1);
	for (int i = 0; i < M + K; i++)
	{
		cin >> a;
		if (a == 1)
		{
			cin >> b >> c >> d;
			update_range(tree, lazy, 1, 0, N - 1, b-1, c-1, d);//
		}
		else if( a== 2)
		{
			cin >> b >> c;
			cout << sum(tree, lazy, 1, 0, N - 1, b-1, c-1) << endl;//
		}
	}
	return 0;
}