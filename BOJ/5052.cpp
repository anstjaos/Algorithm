#include <stdio.h>

typedef struct Trie {
	Trie *arr[10];
	bool check;

	Trie() {
		for (register int i = 0; i < 10; i++) arr[i] = 0;
		check = false;
	}
}Trie;

Trie triePool[1000001];
Trie *head;
int poolCnt, tc, N;
char input[10005][12];

int strcmp(const char *s, const char *s1)
{
	int idx = 0;
	while (s[idx] == s1[idx])
	{
		idx++;

		if (s[idx] == 0) break;
	}

	return s[idx] - s1[idx];
}

int strlen(const char *s)
{
	int len = 0;
	while (s[len] != 0) len++;
	return len;
}

void swap(char *s, char *s1)
{
	char temp[12] = { 0, };
	int idx = 0;
	while (s[idx] != 0) {
		temp[idx] = s[idx];
		idx++;
	}
	idx = 0;
	while (s1[idx] != 0) {
		s[idx] = s1[idx];
		idx++;
	}
	s[idx] = 0;

	idx = 0;
	while (temp[idx] != 0) {
		s1[idx] = temp[idx];
		idx++;
	}
	s1[idx] = 0;
}

void quickSort(const int left, const int right)
{
	int leftIndex = left;
	int rightIndex = right;
	char *pivot = input[(left + right) / 2];

	while (leftIndex <= rightIndex)
	{
		while (strcmp(input[leftIndex], pivot) < 0) {
			if (leftIndex == right) break;
			leftIndex++;
		}
		while (strcmp(input[rightIndex], pivot) > 0) {
			if (rightIndex == left) break;
			rightIndex--;
		}

		if (leftIndex <= rightIndex)
		{
			swap(input[leftIndex], input[rightIndex]);
			leftIndex++;
			rightIndex--;
		}
	}

	if (leftIndex < right) quickSort(leftIndex, right);
	if (left < rightIndex) quickSort(left, rightIndex);
}

void init()
{
	for (register int i = 0; i < poolCnt; i++) {
		for (register int j = 0; j < 10; j++) triePool[i].arr[j] = 0;
		triePool[i].check = false;
	}
	head = &triePool[0];
	poolCnt = 1;
}

int main()
{
	scanf("%d", &tc);
	for (register int t = 0; t < tc; t++)
	{
		init();
		scanf("%d", &N);
		for (register int i = 0; i < N; i++) scanf(" %s", input[i]);

		quickSort(0, N - 1);

		bool check = true;
		for (register int i = 0; i < N; i++)
		{
			int len = strlen(input[i]);
			Trie *ptr = head;
			check = true;
			for (register int j = 0; j < len; j++)
			{
				if (ptr->check == true) {
					check = false;
					break;
				}

				int num = input[i][j] - '0';
				if (ptr->arr[num] == 0) {
					ptr->arr[num] = &triePool[poolCnt];
					poolCnt++;
				}

				ptr = ptr->arr[num];
			}
			ptr->check = true;
			if (!check) break;
		}

		if (check) printf("YES\n");
		else printf("NO\n");
	}
	return 0;
}