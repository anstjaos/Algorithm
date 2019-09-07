#include <string>
#include <vector>

using namespace std;

int map[100][100], rot[40][40];

void rotateKey(vector<vector<int> > &key)
{
	int keySize = key.size();

	for (register int i = 0; i < keySize; i++) {
		for (register int j = 0; j < keySize; j++) {
			rot[j][keySize - 1 - i] = key[i][j];
		}
	}

	for (register int i = 0; i < keySize; i++) {
		for (register int j = 0; j < keySize; j++) {
			key[i][j] = rot[i][j];
		}
	}
}

bool solve(int keySize, int lockSize)
{
	for (register int i = 0; i <= keySize + lockSize; i++) {
		for (register int j = 0; j <= keySize + lockSize; j++) {

			for (register int l = 0; l < keySize; l++) {
				for (register int m = 0; m < keySize; m++) {
					map[i + l][j + m] += rot[l][m];
				}
			}

			bool isOkay = true;
			for (register int l = 0; l < lockSize; l++) {
				for (register int m = 0; m < lockSize; m++) {
					if (map[keySize + l][keySize + m] != 1) {
						isOkay = false;
						break;
					}
				}
				if (!isOkay) break;
			}

			if (isOkay) return true;

			for (register int l = 0; l < keySize; l++) {
				for (register int m = 0; m < keySize; m++) {
					map[i + l][j + m] -= rot[l][m];
				}
			}
		}
	}
	return false;
}

bool solution(vector<vector<int>> key, vector<vector<int>> lock) {
	bool answer = false;
	int keySize = key.size();
	int lockSize = lock.size();

	bool check = true;
	for (register int i = 0; i < lockSize; i++) {
		for (register int j = 0; j < lockSize; j++) {
			map[keySize + i][keySize + j] = lock[i][j];
			if (lock[i][j] == 0) check = false;
		}
	}
	if (check) return true;

	for (register int i = 0; i < 4; i++) {
		rotateKey(key);
		if (solve(keySize, lockSize)) {
			answer = true;
			break;
		}
	}
	return answer;
}

int main()
{
	vector<vector<int> > key = { {0, 0, 0},{1, 0, 0},{0, 1, 1} };
	vector<vector<int> > lock = { {0, 0, 0},{0, 0, 0},{0, 0, 0} };

	solution(key, lock);
}