#ifndef _CRT_SECURE_NO_WARNINGS
#define _CRT_SECURE_NO_WARNINGS
#endif

#include <stdio.h>
typedef unsigned long long ulong;
//-----------------------------------
//	User API

#define HASH_KEY 1000007
#define MAX_SIZE 1500005

struct Hash {
	unsigned long long num;
	Hash* left;
	Hash* right;
};

Hash* hashTable[HASH_KEY];
Hash hashPool[MAX_SIZE];
int poolCount;

int getHashKey(unsigned long long key)
{
	return key % HASH_KEY;
}

void init()
{
	Hash temp = { 0, 0, 0 };
	for (register int i = 0; i < poolCount; i++) hashPool[i] = temp;
	for (register int i = 0; i < HASH_KEY; i++) hashTable[i] = 0;
	poolCount = 0;
}

int checkKey(ulong key)
{
	int hashKey = getHashKey(key);

	Hash* ptr = hashTable[hashKey];
	while (ptr != 0)
	{
		if (ptr->num == key) return 0;
		ptr = ptr->right;
	}

	hashPool[poolCount] = { key, 0, hashTable[hashKey] };
	if (hashTable[hashKey] != 0) hashTable[hashKey]->left = &hashPool[poolCount];
	hashTable[hashKey] = &hashPool[poolCount++];
	return 1;
}

//-----------------------------------

static int run(int Ans)
{
	init();

	int N, ret = 0;
	ulong key;
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		scanf("%lld %d", &key, &ret);

		if (ret != checkKey(key))
			Ans = 0;
	}
	return Ans;
}
int main()
{
	setbuf(stdout, NULL);

	int T, Ans = 100;
	scanf("%d", &T);

	for (int tc = 1; tc <= T; tc++) {
		printf("#%d %d\n", tc, run(Ans));
	}

	return 0;
}