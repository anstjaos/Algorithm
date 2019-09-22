#include <stdio.h>

typedef struct {
	int start;
	int end;
}UseToilet;

UseToilet utArr[1005];
int N, toilet;

bool cmp(const UseToilet& a, const UseToilet& b)
{
	if (a.end == b.end) return a.start < b.start;
	return a.end < b.end;
}

int main()
{
	scanf("%d", &N);
	for (register int i = 0; i < N; i++) {
		scanf("%d %d", &utArr[i].start, &utArr[i].end);
	}

	for (register int i = 0; i < N; i++) {
		bool checkUse = false;
		for (register int j = 1; j <= toilet; j++) {
			if (utArr[i].start >= utArr[i - j].end) {
				checkUse = true;
				break;
			}
		}
		
		if (!checkUse) toilet++;
	}

	printf("%d\n", toilet);
	return 0;
}