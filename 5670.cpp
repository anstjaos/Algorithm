#include <stdio.h>

typedef struct a {
	bool end;
	int cnt;
	a* trie[26];
}Trie;

Trie triePool[100006];
int N, trieCnt;
float cnt;
char input[100005][81];

void init()
{
	for (register int i = 0; i < trieCnt; i++) {
		triePool[i].cnt = 0;
		triePool[i].end = false;
		for (register int j = 0; j < 26; j++) {
			triePool[i].trie[j] = 0;
		}
	}
}

int main()
{
	while (~scanf("%d", &N))
	{
		cnt = 0.0;
		trieCnt = 1;
		for (register int i = 0; i < N; i++) {
			scanf("%s", input[i]);
			
			int idx = 0;
			Trie* ptr = &triePool[0];
			while (input[i][idx] != '\0') {
				int word = input[i][idx] - 'a';
				if (ptr->trie[word] == 0)
				{
					ptr->cnt++;
					ptr->trie[word] = &triePool[trieCnt++];
				}
				ptr = ptr->trie[word];
				idx++;
			}
			ptr->end = true;
		}

		for (register int i = 0; i < N; i++) {
			int idx = 0;
			Trie *ptr = &triePool[0];

			while (input[i][idx] != '\0') {
				int word = input[i][idx] - 'a';
				ptr = ptr->trie[word];
				if (ptr->cnt > 1 ||ptr->end == true) {
					cnt++;
				}
				
				idx++;
			}
		}
		printf("%.2f\n", cnt / (float)N);
		init();
	}
	return 0;
}