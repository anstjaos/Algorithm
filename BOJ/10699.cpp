#include <iostream>
#include <string>
#include <stdio.h>
#include <time.h>

const std::string currentDateTime() {
	time_t     now = time(0); //���� �ð��� time_t Ÿ������ ����
	struct tm  tstruct;
	char       buf[80];
	tstruct = *localtime(&now);
	strftime(buf, sizeof(buf), "%Y-%m-%d", &tstruct); // YYYY-MM-DD.HH:mm:ss ������ ��Ʈ��

	return buf;
}

int main() {
	std::cout << currentDateTime() << std::endl;
}