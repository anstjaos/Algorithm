#include<stdio.h>
#include <cstring>
#include<algorithm>
#include<vector>
using namespace std;
int totalcount;
int count1;
char name[100001][21];
char a[21];
vector<pair<char*, int>> v;
void search(int start, int end, char n[21])
{
	while (end >= start)
	{
		int middle = (start + end) / 2;
		if (strcmp(v[middle].first,n) == 0)
		{
			printf("%d\n",v[middle].second + 1);
			return;
		}
		else if (strcmp(v[middle].first, n) > 0)
		{
			end = middle - 1;
		}
		else
		{
			start = middle + 1;
		}
	}

}

bool comp(const pair<char*, int> &a, const pair<char*, int> &b)
{
	if (strcmp(a.first, b.first) < 0) return true;
	return false;
}

int main()
{
	//ios_base::sync_with_stdio(false);
	//cin.tie(NULL);
	//cout.tie(NULL);

	scanf("%d %d", &totalcount, &count1);
	for (int i = 0; i < totalcount; i++)
	{
		scanf("%s", name[i]);
		v.push_back(make_pair(name[i], i));
	}

	sort(v.begin(), v.end(), comp);

	for (int i = 0; i < count1; i++)
	{
		scanf("%s", a);
		
		if (a[0] < 64)
		{
			printf("%s\n", name[atoi(a) - 1]);
		}
		else
		{
			search(0, totalcount - 1, a);
		}
	}
}

//#include <string>
//#include <stdio.h>
//using namespace std;
//
//#define MAX_SIZE 100005
//#define HASH_SIZE 550
//
//typedef struct a {
//	int index;
//	a* left;
//	a* right;
//}Poke;
//
//int N, M, poolCnt;
//char input[50];
//char arr[MAX_SIZE][50];
//Poke pokePool[MAX_SIZE];
//Poke *hashTable[HASH_SIZE];
//
//int calHash(char str[50])
//{
//	int res = str[0] - 'A';
//	int index = 1;
//	while(str[index] != '\0') {
//		res += (str[index] - 'a');
//		index++;
//	}
//
//	return res;
//}
//
//bool compStr(char *str1, char *str2)
//{
//	int idx = 0;
//	while (str1[idx] != '\0' && str2[idx] != '\0' && str1[idx] == str2[idx]) idx++;
//
//	if (str1[idx - 1] == str2[idx - 1] && str1[idx] == '\0' && str2[idx] == '\0') return true;
//	return false;
//}
//
//int main()
//{
//	scanf("%d %d", &N, &M);
//	for (register int i = 1; i <= N; i++) {
//		scanf("%s", arr[i]);
//		pokePool[poolCnt] = { i, 0, 0 };
//		int hash = calHash(arr[i]);
//
//		if (hashTable[hash] != 0) {
//			hashTable[hash]->left = &pokePool[poolCnt];
//		}
//		pokePool[poolCnt].right = hashTable[hash];
//		hashTable[hash] = &pokePool[poolCnt];
//		poolCnt++;
//	}
//
//	for (register int i = 0; i < M; i++) {
//		scanf("%s", input);
//		if ('0' <= input[0] && input[0] <= '9') {
//			int index = atoi(input);
//			printf("%s\n", arr[index]);
//		}
//		else
//		{
//			int hash = calHash(input);
//			Poke* ptr = hashTable[hash];
//			while (ptr != 0) {
//				if (compStr(input, arr[ptr->index])) {
//					printf("%d\n", ptr->index);
//					break;
//				}
//				ptr = ptr->right;
//			}
//		}
//	}
//
//	return 0;
//}