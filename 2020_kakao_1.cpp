#include <string>
#include <vector>
using namespace std;

int min(int a, int b) { return (a < b ? a : b); }

bool strCmp(string s, int befStart, int curStart, int size)
{
	for (register int i = 0; i < size; i++) {
		if (s[befStart + i] != s[curStart + i]) return false;
	}
	return true;
}

int solution(string s) {
	int answer = 0;
	int len = s.size();
	answer = len;

	for (register int i = 1; i <= len/2; i++)
	{
		register int j = i;
		int cnt = 0, res = len;
		for (; j + i <= len; j += i) {
			if (strCmp(s, j-i, j, i)) cnt++;
			else {
				if (cnt != 0) {
					res = res- (i * cnt);
					cnt++;
					while (cnt != 0) {
						res++;
						cnt /= 10;
					}
				}
			}
		}
		if (cnt != 0) {
			res = res - (i * cnt);
			cnt++;
			while (cnt != 0) {
				res++;
				cnt /= 10;
			}
		}
		answer = min(answer, res);
	}
	return answer;
}

char input[5000];
int main()
{
	scanf("%s", input);
	printf("%d\n", solution(input));
}