#include <cstdio>

int A[5005], B[5005], len, res;
int diff[5005];

int max(int a, int b) { return (a > b ? a : b); }

int main()
{
	int tc = 0;
	scanf("%d", &tc);

	for (register int t = 1; t <= tc; t++)
	{
		res = 0;
		scanf("%d", &len);
		for (register int i = 0; i < len; i++) scanf("%d", A + i);
		for (register int i = 0; i < len; i++) {
			scanf("%d", B + i);
			diff[i] = 0;
		}
		bool flag = false;
		int idx = 0;
		for (register int i = 0; i < len; i++) {
			if (A[i] == B[i]) {
				res++;
				if (flag) {
					flag = false;
					diff[idx] = i - 1;
				}
			}
			else {
				if (flag == false) {
					flag = true;
					idx = i;
				}
			}
		}
		int initVal = res;
		if (flag) diff[idx] = len - 1;

		for (register int i = 0; i < len; i++) {
			if (diff[i] == 0) continue;
			
			for (register int j = i; j < diff[i]; j++) {
				for (register int k = diff[i]; k > j; k--) {
					int temp = initVal;
					idx = 0;
					while (idx <= k - j) {
						if (B[j + idx] == A[k - idx]) temp++;
						idx++;
					}
					res = max(res, temp);
				}
			}
		}
		printf("Case #%d\n%d\n", t, res);
	}
	return 0;
}