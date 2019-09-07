#include <string>
#include <vector>
#include <map>
using namespace std;
bool check[1 << 9];

bool checkColumn(int num)
{
	for (register int i = 1; i <= num; i++) {
		if (check[num & i]) return false;
	}
	return true;
}

bool checkComb(vector<vector<string> > &relation, int comb)
{
	map<string, int> strList;
	int row = relation.size();
	
	for (register int i = 0; i < row; i++) {
		string word = "";
		int cnt = 0, temp = comb;
		
		while (temp != 0) {
			if (temp & 1) {
				word += relation[i][cnt];
			}

			cnt++;
			temp >>= 1;
		}
		
		if (strList[word] == comb) return false;
		strList[word] = comb;
	}
	return true;
}

int solution(vector<vector<string>> relation) {
	int answer = 0;

	int col = relation[0].size();

	for (register int i = 1; i < (1 << col); i++) {
		if (!checkColumn(i)) continue;
		if (checkComb(relation, i)) {
			check[i] = true;
			answer++;
		}
	}
	return answer;
}