#include <string>
#include <vector>
#define MOD 1000007
using namespace std;

typedef struct {
	int index;
	int size;
}HashNode;

vector<HashNode> frontHashTable[MOD];
vector<HashNode> backHashTable[MOD];
int sizeTable[10001];

vector<int> solution(vector<string> words, vector<string> queries) {
	vector<int> answer;
	int wSize = words.size();

	for (register int i = 0; i < wSize; i++) {
		int wordLen = words[i].size();
		sizeTable[wordLen]++;
		unsigned long hash = 5381;
		for (register int j = 0; j < wordLen; j++) {
			hash = (((hash << 5) + hash) + (words[i][j] - 'a')) % MOD;
			frontHashTable[hash].push_back({ i,wordLen });
		}

		hash = 5381;
		for (register int j = wordLen - 1; j >= 0; j--) {
			hash = (((hash << 5) + hash) + (words[i][j] - 'a')) % MOD;
			backHashTable[hash].push_back({ i, wordLen });
		}
	}

	int qSize = queries.size();
	for (register int i = 0; i < qSize; i++) {
		int cnt = 0;
		long long hash = 5381;
		int len = queries[i].size(), wordLen = 0;
		bool isFront = false, allcheck = false;

		if (queries[i][0] != '?') {
			for (register int j = 0; j < len && queries[i][j] != '?'; j++) {
				hash = (((hash << 5) + hash) + (queries[i][j] - 'a')) % MOD;
				wordLen++;
			}
			isFront = true;
		}
		else if (queries[i][0] == '?' && queries[i][len - 1] == '?') allcheck = true;
		else {
			for (register int j = len - 1; j >= 0 && queries[i][j] != '?'; j--) {
				hash = (((hash << 5) + hash) + (queries[i][j] - 'a')) % MOD;
				wordLen++;
			}
			isFront = false;
		}

		if (allcheck)
		{
			answer.push_back(sizeTable[len]);
			continue;
		}

		if (isFront) {
			for (HashNode cur : frontHashTable[hash])
			{
				int wordSize = cur.size;
				if (wordSize != len) continue;

				bool check = true;

				int index = cur.index;
				for (register int j = 0; j < wordLen; j++) {
					if (words[index][j] != queries[i][j]) {
						check = false;
						break;
					}
				}

				if (check) cnt++;
			}
		}
		else {
			for (HashNode cur : backHashTable[hash])
			{
				int wordSize = cur.size;
				if (wordSize != len) continue;

				bool check = true;
				
				int index = cur.index;
				for (register int j = 0; j < wordLen; j++) {
					if (words[index][wordSize - 1 - j] != queries[i][wordSize - 1 - j]) {
						check = false;
						break;
					}
				}
				
				if (check) cnt++;
			}
		
		}

		answer.push_back(cnt);
	}
	return answer;
}

int main()
{
	vector<string> words = { "frodo", "front", "frost", "frozen", "frame", "kakao" };
	vector<string> queries = { "fro??", "????o", "fr???", "fro???", "pro?" };

	solution(words, queries);
}