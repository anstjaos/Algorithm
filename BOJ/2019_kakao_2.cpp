#include <string>
#include <vector>
#include <algorithm>
using namespace std;

typedef struct {
	int stage;
	double fail;
}Stage;

Stage stageArr[505];
int cnt[505];

bool cmp(const Stage &a, const Stage &b)
{
	if (a.fail == b.fail) return a.stage < b.stage;
	return a.fail > b.fail;
}

vector<int> solution(int N, vector<int> stages) {
	vector<int> answer;
	int stagesCnt = stages.size();
	for (register int i = 0; i < stagesCnt; i++) cnt[stages[i]]++;

	int sum = stagesCnt;
	for (register int i = 1; i <= N; i++) {
		if (sum == 0) stageArr[i] = { i ,0.0 };
		else stageArr[i] = { i, (double)cnt[i] / sum };
		sum -= cnt[i];
	}

	sort(stageArr + 1, stageArr + N + 1, cmp);
	for (register int i = 1; i <= N; i++) answer.push_back(stageArr[i].stage);
	return answer;
}