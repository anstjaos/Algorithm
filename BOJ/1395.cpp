#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

int N, M;

void update_lazy(vector<int> &tree, vector<int> &lazy, int index, int start, int end)
{
	if (lazy[index])
	{
		tree[index] = end - start + 1 - tree[index];

		if (start != end)
		{
			lazy[index * 2] = !lazy[index * 2];
			lazy[index * 2 + 1] = !lazy[index * 2 + 1];
		}

		lazy[index] = 0;
	}
}


int update_tree(vector<int> &tree, vector<int> &lazy, int index, int start, int end, int left, int right)
{
	update_lazy(tree, lazy, index, start, end);

	if (right < start || end < left) return tree[index];
	if (left <= start && end <= right)
	{
		tree[index] = end - start + 1 - tree[index];

		if (start != end)
		{
			lazy[index * 2] = !lazy[index * 2];
			lazy[index * 2 + 1] = !lazy[index * 2 + 1];
		}

		return tree[index];
	}

	return tree[index] = update_tree(tree, lazy, index * 2, start, (start + end) / 2, left, right) + update_tree(tree, lazy, index * 2 + 1, (start + end) / 2 + 1, end, left, right);
}

int sum(vector<int> &tree, vector<int> &lazy, int index, int start, int end, int left, int right)
{
	update_lazy(tree, lazy, index, start, end);

	if (right < start || end < left) return 0;
	if (left <= start && end <= right)
	{
		return tree[index];
	}

	return sum(tree, lazy, index * 2, start, (start + end) / 2, left, right) + sum(tree, lazy, index * 2 + 1, (start + end) / 2 + 1, end, left, right);
}

int main()
{
	cin >> N >> M;

	int height = ceil(log2(N)) + 1;
	vector<int> tree((1 << height));
	vector<int> lazy(1 << height);

	for (int i = 0; i < M; i++)
	{
		int O, S, T;
		cin >> O >> S >> T;
		if (O == 0)
		{
			update_tree(tree, lazy, 1, 1, N, S, T);
		}
		else
		{
			cout << sum(tree, lazy, 1, 1, N, S, T) << endl;
		}
	}

	return 0;
}