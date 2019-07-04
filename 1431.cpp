#include <cstdio>
#include <algorithm>
#include <cstring>
using namespace std;

typedef struct {
	char input[51];
	int len;
	int sum;
}SerialNum;

SerialNum serialArr[1005];
bool cmp(const SerialNum &a, const SerialNum &b)
{
	if (a.len != b.len) return a.len < b.len;
	else if (a.sum != b.sum) return a.sum < b.sum;
	else {
		if (strcmp(a.input, b.input) < 0) return true;
	}
	
	return false;
}

int main()
{
	int n;
	scanf("%d", &n);
	for (register int i = 0; i < n; i++) {
		scanf("%s", &serialArr[i].input);
		int idx = 0;
		while (serialArr[i].input[idx] != '\0') {
			
			if ('0' <= serialArr[i].input[idx] && serialArr[i].input[idx] <= '9') {
				serialArr[i].sum += serialArr[i].input[idx] - '0';
			}
			idx++;
		}
		serialArr[i].len = idx;
	}
	sort(serialArr, serialArr + n, cmp);
	for (register int i = 0; i < n; i++) {
		printf("%s\n", serialArr[i].input);
	}
	return 0;
}