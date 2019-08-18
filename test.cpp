/*#include <iostream>
#include <string>
using namespace std;

int N, x, y, size;
string arr[21];

int main(void) {
	size = 1;
	arr[0] = "0";
	for (register int i = 1; i < 21; i++) {
		string temp = arr[i - 1];
		for (register int j = 0; j < size; j++) {
			if (arr[i - 1][j] == '0') temp += "1";
			else temp += "0";
		}
		arr[i] = temp;
		size = (size << 1);
	}
	scanf("%d %d %d", &N, &x, &y);

	if ()
		for (register int i = x - 1; i < y; i++) {
			printf("%c", input[i]);
		}
	printf("\n");
	return 0;
}*/

#include <iostream>
#include <string>
using namespace std;

int N, x, y, s;
string arr[21], result;

void divide(int l, int r, int left, int right)
{
	if (r - l == 0) {
		result += "0";
		return;
	}
	int size = r - l + 1;
	if (size <= (1 << 20)) {
		int cnt = 0;
		while ((1 << cnt) != size) cnt++;
		if (((r + 1) / size) & 1) {
			for (register int i = left - l - 1; i < r - left; i++) {
				result += arr[cnt + 1][i];
			}
		}
		else {
			string temp = arr[cnt + 1];
			reverse(temp.begin(), temp.end());
			for (register int i = left - l - 1; i < r - left; i++) {
				result += temp[i];
			}
		}
		return;
	}

	if (left < size / 2 && right < size / 2) {
		divide(0, size / 2 - 1, left, right);
	}
	else if (left < size / 2 && right >= size / 2) {
		divide(0, size / 2 - 1, left, size / 2 - 1);
		divide(size / 2, size - 1, size / 2, right);
	}
	else {
		divide(size / 2, size - 1, left, right);
	}
}

void solve()
{
	long long size = 1;
	for (register int i = 1; i < N; i++) {
		size = (size << 1);
	}

	if (x - 1 < size / 2 && y - 1 < size / 2) {
		divide(0, size / 2 - 1, x - 1, y - 1);
	}
	else if (x - 1 < size / 2 && y - 1 >= size / 2) {
		divide(0, size / 2 - 1, x - 1, size / 2 - 1);
		divide(size / 2, size - 1, size / 2, y - 1);
	}
	else {
		divide(size / 2, size - 1, x - 1, y - 1);
	}
}

int main(void) {
	s = 1;
	result = "";
	arr[1] = "0";
	for (register int i = 2; i < 21; i++) {
		string temp = arr[i - 1];
		for (register int j = 0; j < s; j++) {
			if (arr[i - 1][j] == '0') temp += "1";
			else temp += "0";
		}
		arr[i] = temp;
		s = (s << 1);
	}
	scanf("%d %d %d", &N, &x, &y);

	if (N <= 20) {
		for (register int i = x - 1; i < y; i++) {
			printf("%c", arr[N][i]);
		}
		printf("\n");
	}
	else {
		solve();
		cout << result << "\n";
	}
	return 0;
}