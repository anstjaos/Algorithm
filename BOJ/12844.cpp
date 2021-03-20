#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

vector<int> arr(500001);
int n, m, t, a, b, c;

int init(vector<int> &tree, int index, int start, int end)
{
	if (start == end) return tree[index] = arr[start];

	return tree[index] = init(tree, index * 2, start, (start+end)/2) ^ init(tree, index * 2 + 1, (start+end)/2+1, end);
}

void update_lazy(vector<int> &tree, vector<int> &lazy, int index, int start, int end)
{
	if (lazy[index])
	{
		tree[index] = tree[index] ^ lazy[index] * ((end-start+1) %2);
		
		if (start != end)
		{
			lazy[index * 2] ^= lazy[index];
			lazy[index * 2 + 1] ^= lazy[index];
		}

		lazy[index] = 0;
	}
}

int update_range(vector<int> &tree, vector<int>& lazy, int index, int start, int end, int left, int right, int c)
{
	update_lazy(tree, lazy, index, start, end);
	if (left > end || right < start) return tree[index];
	if (left <= start && end <= right)
	{
		tree[index] = tree[index] ^ c * ((end - start + 1) % 2);
		if (start != end)
		{
			lazy[index * 2] ^= c;
			lazy[index * 2 + 1] ^= c;
		}
		return tree[index];
	}

	return tree[index] = update_range(tree, lazy, index * 2, start, (start + end) / 2, left, right, c) ^ update_range(tree, lazy, index * 2 + 1, (start + end) / 2 + 1, end, left, right, c);
}

int xor_range(vector<int> &tree, vector<int> &lazy, int index, int start, int end, int left, int right)
{
	update_lazy(tree, lazy, index, start, end);

	if (left > end || right < start) return 0;
	if (left <= start && end <= right) return tree[index];

	return xor_range(tree, lazy, index*2, start, (start + end) / 2, left, right) ^ xor_range(tree, lazy, index *2 +1,(start + end) / 2 + 1, end, left, right);
}

int main()
{
	scanf("%d ", &n);
	for (int i = 0; i < n; i++) scanf("%d ", &arr[i]);

	scanf("%d ", &m);
	int h = (int)ceil(log2(n)) + 1;
	vector<int> tree(1 << h);
	vector<int> lazy(1 << h);

	init(tree, 1, 0, n - 1);
	for (int i = 0; i < m; i++)
	{
		scanf("%d %d %d ", &t, &a, &b);
		if (t == 1)
		{
			scanf("%d ", &c);
			update_range(tree, lazy, 1, 0, n - 1, a , b, c);
		}
		else if (t == 2)
		{
			printf("%d\n", xor_range(tree, lazy, 1, 0, n - 1, a, b));
		}
	}

}