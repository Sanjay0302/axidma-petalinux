SUMMARY = "DMA Proxy kernel driver and userspace test application"
SECTION = "PETALINUX/modules"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/linux-user-space-dma/LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

inherit module

SRC_URI = "git://github.com/Sanjay0302/software-prototypes.git;protocol=https;branch=master"
SRCREV = "${AUTOREV}"

# Point S to the kernel driver directory
S = "${WORKDIR}/git/linux-user-space-dma/Software/Kernel"
USERSPACE_DIR = "${WORKDIR}/git/linux-user-space-dma/Software/User"

do_compile:append() {
    oe_runmake -C ${USERSPACE_DIR} clean
    oe_runmake -C ${USERSPACE_DIR} \
        CC="${CC}" \
        CFLAGS="${CFLAGS}" \
        LDFLAGS="${LDFLAGS}"
}

do_install:append() {
    install -d ${D}${bindir}
    install -m 0755 ${USERSPACE_DIR}/dma-proxy-test ${D}${bindir}/
}

FILES:${PN} += "${bindir}/dma-proxy-test"
