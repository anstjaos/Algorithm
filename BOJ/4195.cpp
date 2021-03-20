#include <stdio.h>
#define MAX_PERSON 50005
#define MAX_HASH 300003

typedef struct Person {
	char name[20];
	int index;
	Person *next;
}Person;

Person personPool[MAX_PERSON];
int poolCnt, parent[MAX_PERSON], rank[MAX_PERSON], idx;
Person *hashTable[MAX_HASH];
char name1[20], name2[20];

void init()
{
	Person temp = { {'\0',}, 0 };

	for (register int i = 0; i < MAX_PERSON; i++) {
		personPool[i] = temp;
		parent[i] = i;
		rank[i] = 1;
	}

	for (register int i = 0; i < MAX_HASH; i++) hashTable[i] = 0;
	poolCnt = 0;
	idx = 0;
}

int calHash(const char *s)
{
	long long hash = 0;
	register int i = 0;

	while (s[i] != 0) {
		hash = (hash * 10) + (s[i] - 'A');
		i++;
	}

	return (hash % MAX_HASH);
}

int strCmp(const char *s1, const char *s2)
{
	register int i = 0;
	while (s1[i] != 0)
	{
		if (s1[i] != s2[i]) break;
		i++;
	}

	return s1[i] - s2[i];
}

void strCpy(const char* src, char* dest)
{
	register int i = 0;
	while (src[i] != 0) {
		dest[i] = src[i];
		i++;
	}
	dest[i + 1] = '\0';
}

int findIndex(const char *s)
{
	int hash = calHash(s);
	Person *ptr = hashTable[hash];
	while (ptr != 0)
	{
		if (strCmp(ptr->name, s) == 0) break;
		ptr = ptr->next;
	}

	if (ptr == 0) {
		ptr = &personPool[poolCnt++];
		strCpy(s, ptr->name);
		ptr->index = idx++;
		ptr->next = hashTable[hash];
		hashTable[hash] = ptr;
	}

	return ptr->index;
}

int findParent(int index)
{
	if (parent[index] == index) return index;
	return parent[index] = findParent(parent[index]);
}

int unionSet(int n1Idx, int n2Idx)
{
	int n1Parent = findParent(n1Idx);
	int n2Parent = findParent(n2Idx);

	if (n1Parent == n2Parent) return rank[n1Parent];

	int ret = 0;
	if (n1Parent < n2Parent)
	{
		parent[n2Parent] = n1Parent;
		rank[n1Parent] += rank[n2Parent];
		ret = rank[n1Parent];
	}
	else {
		parent[n1Parent] = n2Parent;
		rank[n2Parent] += rank[n1Parent];
		ret = rank[n2Parent];
	}

	return ret;
}

int main()
{
	int tc;
	scanf("%d", &tc);
	while (tc--)
	{
		init();
		int cnt;
		scanf("%d", &cnt);
		for (register int i = 0; i < cnt; i++)
		{
			scanf(" %s %s", name1, name2);
			int name1Idx = findIndex(name1);
			int name2Idx = findIndex(name2);

			printf("%d\n", unionSet(name1Idx, name2Idx));
		}
	}

	return 0;
}