#include <cstdio>
#include <queue>
#include <algorithm>
using namespace std;
int n, r;
pair<int, int> p[10000];
priority_queue<int> pq;

int main() {
	scanf("%d", &n);
	for (register int i = 0; i < n; i++) scanf("%d %d", &p[i].second, &p[i].first);
	sort(p, p + n);
	for (register int i = 0; i < n; i++) {
		r += p[i].second;
		pq.push(-p[i].second);
		if (pq.size() > p[i].first) r += pq.top(), pq.pop();
	}
	printf("%d", r);
	return 0;
}