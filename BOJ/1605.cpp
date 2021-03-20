#include <stdio.h>
#include <vector>
using namespace std;

#define MAX_HASH 10007

int len, square[200001], res;
vector<long long> hashTable[MAX_HASH];
char input[200001];

int max(int a, int b) { return (a > b ? a : b); }

bool stringMatch(int idx1, int idx2, int L)
{
	for (register int i = 0; i < L; i++) {
		if (input[idx1 + i] != input[idx2 + i]) return false;
	}
	return true;
}

bool solve(const int L)
{
	for (register int i = 0; i < MAX_HASH; i++) hashTable[i].clear();

	int hash = 0;

	for (register int i = 0; i < L; i++) {
		hash *= 17;
		hash += (input[i] - 'a');
		hash %= MAX_HASH;
	}

	hashTable[hash].push_back(0);
	for (register int i = L; i < len; i++) {
		hash -= square[L-1] * (input[i-L] - 'a') % MAX_HASH;
		hash = (hash + MAX_HASH )% MAX_HASH;
		hash *= 17;
		hash += input[i] - 'a';
		hash %= MAX_HASH;

		for (int temp : hashTable[hash]) {
			if (stringMatch(temp, i-L+1, L)) return true;
		}

		hashTable[hash].push_back(i - L+1);
	}

	return false;
}

int main()
{
	scanf("%d %s", &len, input);
	square[0] = 1;
	
	for (register int i = 1; i <= len; i++) {
		square[i] = (square[i - 1] * 17) % MAX_HASH;
	}

	int left = 0, right = len;
	while (left < right)
	{
		int mid = (left + right) / 2;

		if (solve(mid)) {
			left = mid + 1;
			res = max(res, mid);
		}
		else right = mid-1;
	}

	printf("%d\n", left);
	return 0;
}