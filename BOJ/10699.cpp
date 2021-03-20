#include <iostream>
#include <string>
#include <stdio.h>
#include <time.h>

const std::string currentDateTime() {
	time_t     now = time(0); //현재 시간을 time_t 타입으로 저장
	struct tm  tstruct;
	char       buf[80];
	tstruct = *localtime(&now);
	strftime(buf, sizeof(buf), "%Y-%m-%d", &tstruct); // YYYY-MM-DD.HH:mm:ss 형태의 스트링

	return buf;
}

int main() {
	std::cout << currentDateTime() << std::endl;
}