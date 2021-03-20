#include <stdio.h>
#include <queue>
using namespace std;

int main() {
	int N;
	scanf("%d", &N);
	queue <long long> q;

	int num = -1;
	bool flag = true;

	for (int i = 0; i < 10; i++) {
		q.push(i);
		num++;
		if (N == num)
			break;
	}



	while (1) {
		int len = q.front() % 10;
		if (q.front() < 10) { 
			for (int i = 0; i < q.front(); i++) {
				if (N == num)
					break;
				q.push(q.front() * 10 + i);
				num++;
			}
			q.pop();
		}
		else {
			for (int i = 0; i < len; i++) {
				if (N == num)
					break;
				q.push(q.front() * 10 + i);
				num++;
			}
			q.pop();
		}
		if (q.back() == 9876543210 && N != num) { 
			flag = false;
			break;
		}
		if (N == num)
			break;
	}

	if (flag) printf("%lld\n", q.back());
	else printf("-1\n");

	return 0;
}